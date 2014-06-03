package br.com.cabal.dsl.comunica;

import java.io.IOException;

import org.jpos.iso.BaseChannel;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

public class WaitReply extends Thread{

	
	private BaseChannel channel;
	private ISOMsg response = null;
	Comunicador comunicador =  null;
	
	WaitReply(BaseChannel channel, Comunicador com){
		this.channel = channel;		
		this.comunicador = com;
	}
	@Override
	public void run() {
		aguardarResposta();
	}
	private void aguardarResposta() {
		do {
			try {
					this.response = this.channel.receive();
					comunicador.aguardar = false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			} catch (ISOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}	
		} while (comunicador.aguardar);
		
	}
	public ISOMsg getResponse() {
		return this.response;
	}

	
}
