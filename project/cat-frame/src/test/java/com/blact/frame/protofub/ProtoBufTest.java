package com.blact.frame.protofub;

import org.junit.Test;

import com.blackcat.frame.protobuf.AddressBookProtos.AddressBook;
import com.blackcat.frame.protobuf.AddressBookProtos.Person;
import com.google.protobuf.InvalidProtocolBufferException;

public class ProtoBufTest {
	@Test
	public void test1() {
		Person.Builder pb = Person.newBuilder();
		pb.setId(1);
		pb.setName("11");
		
		AddressBook.Builder builder = AddressBook.newBuilder();
		builder.addPerson(pb.build());
		
		AddressBook book = builder.build();
		byte[] b = book.toByteArray();
		System.out.println(b.length);
		try {
			AddressBook bo2 = AddressBook.parseFrom(b);
			System.out.println(bo2.getPerson(0).getName() );
		} catch (InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		//B yteBuf  b 
		//SimpleLeakAwareByteBuf b = new SimpleLeakAwareByteBuf(1024);
		/*byte[] b = {0,0,1};
		System.out.println(getUnsignedMedium(b,0));*/
		String s = "001";
		byte[] b = s.getBytes();
		System.out.println(b[0] & 0xff);
				
	}
	
	public int getUnsignedMedium(byte[] array, int index) { 
        return  (array[index]     & 0xff) << 16 | 
                (array[index + 1] & 0xff) <<  8 | 
                (array[index + 2] & 0xff) <<  0; 
    } 
	
	@Test 
	public void test3() {
		int a = 0;
		int c = 0;
		do {
			--c;
			a = a -1;
		} while (a > 0) ;
		System.out.println(c);
	}
	
	@Test
	public void test4() {
		int i = 9;
		byte b = 1;
		
		int i1 = b;
		short c = b;
		
	}
	
	@Test 
	public void testException() {
		int a = 0;
		int c = 3;

		try {
			int b = c/a;
		} catch(ArithmeticException e) {
			System.out.println(1);
		} catch(Exception e1) {
			System.out.println(2);
		} 
	}
	
	@Test 
	public void testException2() throws Exception {

		try {
			throw new SbException();
		} catch(SbException e) {
			System.out.println(1);
			throw new Exception();
		} catch(Exception e1) {
			System.out.println(2);
		} 
	}
	private class SbException extends Exception {
		
	}
}
