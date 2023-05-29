package com.example.cuentas.configuration;

class Cat {
	public static void main(String [] args) {
		Cat c1 = new Cat ();
		Cat c3 = new Cat ();
		Cat c2 = c1;
		Cat c4 = c3;
		c1 = c4;
		c4 =c2;
		if (c1==c2) System.out.print("c1 == c2");
		if (c1==c3) System.out.print("c1 == c3");
	}
}