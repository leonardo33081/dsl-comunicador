package br.com.cabal.dsl.comunica;

import org.jpos.iso.ISOMsg;

public interface ChannelBuilder {
	ChannelBuilder enviar();
	ISOMsg transacao();
	
}
