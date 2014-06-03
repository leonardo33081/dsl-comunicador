package br.com.cabal.dsl.comunica;

import org.jpos.iso.BaseChannel;
import org.jpos.iso.ISOMsg;

public class SendTxn {
	private Channel channel;
	private ISOMsg mensagem;
	private final String pacotesJava = "org.jpos.iso.channel";
	private final char ponto ='.';
	
	public SendTxn(Channel channel, ISOMsg mensagem){
		this.channel = channel;
		this.mensagem = mensagem;
	}

	/**
	 * Devolve uma instancia de channel a partir de uma seleção (ENUM)
	 * */
	protected BaseChannel factoryChannel(){
		StringBuilder s = new StringBuilder();
		s.append(pacotesJava);
		s.append(ponto);
		s.append(this.channel);
		
		System.out.println("Criando instancia " + s.toString());
		BaseChannel canal = null;
		try {
			canal = (BaseChannel) Class.forName(s.toString()).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return canal;
	}

	public boolean enviar(BaseChannel canal) {
		try{
			canal.connect();
			canal.send(this.mensagem);
			return true;
		}catch(Exception e){
			e.printStackTrace();			
			return false;
		}
	}
	

}
