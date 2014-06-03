package br.com.cabal.dsl.comunica;

import java.net.SocketException;

import org.jpos.iso.BaseChannel;
import org.jpos.iso.ISOMsg;

public class Comunicador implements ChannelBuilder {

	private SendTxn send = null; 
	private Transacao tr;
	private BaseChannel canal = null;
	private WaitReply response = null;
	boolean aguardar = true;
	
	public Comunicador(Channel channel, Transacao txn){
		this.send = new SendTxn(channel, txn.getMensagem());
		this.tr = txn;
	}
	@Override
	public ChannelBuilder enviar() {
		this.canal = this.send.factoryChannel();
		try {
			long startDate = System.currentTimeMillis();
			this.response = new WaitReply(this.canal, this);
			this.send.enviar(configurarCanal(canal));
			this.response.start();
			aguardar();
			long duration = System.currentTimeMillis() - startDate;
			System.out.println("A transação demorou " + duration + " milissegundos...");
		} catch (SocketException e) {
			System.out.println("Erro no Socket. Motivo:" + e.getMessage());
			e.printStackTrace();
		}catch (InterruptedException e) {
			System.out.println("Erro na espera. Motivo:" + e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	private BaseChannel configurarCanal(BaseChannel canal) throws SocketException {
		canal.setHost(tr.getIp());
		canal.setPort(tr.getPorta());
		canal.setTimeout(tr.getTimeout());
		canal.setPackager(tr.getMensagem().getPackager());
		return canal;
	}
	@Override
	public ISOMsg transacao() {
		return response.getResponse();
	}
	private void aguardar() throws InterruptedException {
		int segundos = this.tr.getTimeout() / 1000;
		for (int i = 0; i < segundos; i++) {
			if(this.aguardar){
				System.out.println("Aguardando...");
				Thread.currentThread().sleep(1000);
			}else
				break;
		}
	}
}

