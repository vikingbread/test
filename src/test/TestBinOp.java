package test;

public class TestBinOp {

	public static void main(String[] args) {
		Byte b = -128;
		
		System.out.println(Byte.toUnsignedInt((byte)-127));

		
		System.out.println(Integer.toHexString(-128&0xff));
		System.out.println(Integer.toHexString(129&0xff));
		
		
		System.out.println((byte)(129&0xff));
		
		
		
		System.out.println(((byte)148) & 0x7F);
		
		
		System.out.println(Byte.toUnsignedInt((byte)-20));
		System.out.println(-20 & 0xff);
		
		System.out.println(Integer.MAX_VALUE >>> 16);
	}

}
