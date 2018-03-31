package org.ukiuni.inspect;

import org.junit.Test;
import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

public class TensorFlowInspect {
	@Test
	public void test() {
		try (Graph g = new Graph(); Session session = new Session(g)) {
			Tensor<?> t = Tensor.create("初めてのTensorFlow".getBytes());
			g.opBuilder("Const", "message").setAttr("dtype", t.dataType()).setAttr("value", t).build();
			Tensor<?> out = session.runner().fetch("message").run().get(0);
			System.out.println(new String(out.bytesValue()));
		}
	}
}
