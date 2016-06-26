//DISCLAIMER works 60% of the time without error

import java.io.*;

public class CompileAll{

	public static void main(String[] args){
		
		String[] programs = {"Card.java","BlackJackPlayer.java", "Player.java"};

		try{
			for (int i = 0; i < programs.length; i++){
				Runtime.getRuntime().exec("javac "+ programs[i]);
				System.out.println("Compiled " + programs[i]);
			}
		} catch(IOException ex){

		}
	}
}