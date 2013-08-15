package com.sanjeeb.java.concepts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableTest {
	public static void main(String[] args) {
		String fileName = "nameStore"; 
		serialize(fileName);
		deSerialize(fileName);
	}
	
	private static void serialize(String fileName) {
		SerTest testObj = new SerTest("namePri", "namePub", "namePro", "nameTran");
		try(ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(fileName)))
		{
			o.writeObject(testObj);
		} catch(IOException ex) {
		}
	}
	
	private static void deSerialize(String fileName) {
		SerTest testObj = null;
		try(ObjectInputStream in =new ObjectInputStream(new FileInputStream(fileName))) {
				testObj = (SerTest)in.readObject();
		} catch (IOException | ClassNotFoundException ex) {
			
		}
        System.out.println(testObj);
	}
	
	
}
class SerTest implements Serializable {
	private String namePri;
	public String namePub;
	protected String namePro;
	private static String nameStat = "staticName";
	private transient String nameTran;
	public SerTest(String namePri, String namePub, String namePro, String nameTran) {
		this.namePri = namePri;
		this.namePub = namePub;
		this.namePro = namePro;
		this.nameTran = nameTran;
	}
	@Override
	public String toString() {
		return "namePri : " + namePri + "\n" +
				"namePub : " + namePub + "\n" +
				"namePro : " + namePro + "\n" +
				"nameStat : " + nameStat + "\n" +
				"nameTran : " + nameTran  + "\n";
 	}
}
