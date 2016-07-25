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
}
