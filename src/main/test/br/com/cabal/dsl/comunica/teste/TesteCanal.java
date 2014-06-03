package br.com.cabal.dsl.comunica.teste;

import java.util.HashMap;
import java.util.Map;

import org.jpos.iso.ISOMsg;

import br.com.cabal.dsl.comunica.Channel;
import br.com.cabal.dsl.comunica.Comunicador;
import br.com.cabal.dsl.comunica.Transacao;

public class TesteCanal {
	//Teste para recriação do jar
//	public static void main(String[] args) {
//		
//		//VOIsoMenssagem i = new VOIsoMenssagem();
//		
//		Map<Integer, String> b = new HashMap<Integer, String>();
//		b.put(0, "0200");
//		b.put(3, "002000");
//		b.put(4, "000000000122");
//		b.put(41, "TGGV1235");
//		b.put(48, "12203123");
//		
//		i.setBits(b);
//		i.setPackager("conf/iso87ascii.xml");
//
//		
//		ISOMsg request=null;
//		try {
//			//request = new GeradorISO8583(i).comBits().comPackager().devolverMensagemISO();
//		//----------------------------------------------------------------------------------------------//
//			Transacao tr = new Transacao();
//			tr.setIp("localhost");
//			tr.setMensagem(request);
//			tr.setPorta(9820);
//			tr.setTimeout(10000);
//		
//			new Comunicador(Channel.ASCIIChannel, tr).enviar().transacao().dump(System.out, "");;
////			System.out.println(new Comunicador(Channel.ASCIIChannel, tr).enviar().transacao());
//		
//		
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}

}
