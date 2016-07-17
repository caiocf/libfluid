import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

import fluid.base.*;
import fluid.msg13.*;

public class LearningSwitch13 extends OFServer {
	static {
		System.loadLibrary("fluid_base");
		System.loadLibrary("fluid_msg_of10");
		System.loadLibrary("fluid_msg_of13");
	}

	static short test(short bytes) {
		return bytes;
	}

	static Map<Integer, Map<Long, Integer>> table = new HashMap<Integer, Map<Long, Integer>>();

	@Override
	public void connection_callback(OFConnection conn,
			OFConnection.Event event_type) {
		System.out.println("## Connection id=" + conn.get_id() + " event="
				+ event_type);
	}

	private Long get_long_mac(byte[] mac) {
		ByteBuffer br = ByteBuffer.allocate(8);
		br.put(mac);
		br.putShort((short) 0x0000);
		br.flip();
		return br.getLong();
	}

	
	private void flood(OFConnection conn, PacketIn pi) {
		// TODO: implement this method

	}

	@Override
	public void message_callback(OFConnection conn, short type, byte[] data,
			long len) {

		System.out.println("Type Packet: "+type + " Version Protcol: "+conn.get_version());
	}

	public LearningSwitch13(String address, int port, int nthreads) {
		super(address, port, nthreads,false,new OFServerSettings().supported_version((short)1).supported_version((short)4).keep_data_ownership(false));
	}

	public static void main(String argv[]) {
		LearningSwitch13 l2 = new LearningSwitch13("0.0.0.0", 6653, 1);
		l2.start(true);
	}
}
