package br.com.cabal.dsl.comunica;

import org.jpos.iso.ISOMsg;

public class Transacao {
	
	private ISOMsg mensagem;
	private int timeout;
	private String ip;
	private int porta;

	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPorta() {
		return porta;
	}
	public void setPorta(int porta) {
		this.porta = porta;
	}
	
	public ISOMsg getMensagem() {
		return mensagem;
	}
	public void setMensagem(ISOMsg mensagem) {
		this.mensagem = mensagem;
	}
	public int getTimeout() {
		return timeout;
	}
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
}
