package email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

import model.vo.Email;

public class GerenciadorEmail {

	public void encaminharEmail(Email email) {
		//Email utilizamo para encaminhar pdf
		//Chave de segurança deste e-mail
		String nomeEmail = "Email_a_ser_utilizado";
		String senha = "Alterar Senha";
		String prazoInicialEditado = email.getPrazoInicial().replaceAll("(\\d{4})-(\\d{2})-(\\d{2})", "$3/$2/$1");
		String prazoFinalEditado = email.getPrazoFinal().replaceAll("(\\d{4})-(\\d{2})-(\\d{2})", "$3/$2/$1");
		
		
		MultiPartEmail emailRemetente = new MultiPartEmail();
		emailRemetente.setHostName("mx1.fecammx.com.br");
		emailRemetente.setSmtpPort(465);
		emailRemetente.setAuthenticator(new DefaultAuthenticator(nomeEmail, senha));
		emailRemetente.setSSLOnConnect(true);
		
		try {
			emailRemetente.setFrom(nomeEmail);
			emailRemetente.setSubject("Treino Completo - " + email.getNomeCliente());
			emailRemetente.setMsg("Olá, " + email.getNomeCliente() + "." + "\n\nSeu treino personalizado foi criado com sucesso pelo personal "
					+ email.getNomePersonal()+ " - "+ email.getEmailPersonal()+ ".\nVocê pode contatar o mesmo por e-mail para quaisquer dúvidas."
							+ "\nPrazo inicial:  " + prazoInicialEditado + "\nPrazo final:  " + prazoFinalEditado
							+ "\nTreino Completo:\n"
							+ email.getTreinoCliente());
			
			emailRemetente.addTo(email.getEmailCliente());
	//		EmailAttachment anexo = new EmailAttachment(); -> Em caso de anexo
	//		anexo.setPath(emailVO.getTermoAdesaoPdf()); -> Caminho do relatório gerado
	//		anexo.setName("Treino".pdf"); -> Nome do arquivo
	//		email.attach(anexo); -> Anexa o arquivo
			emailRemetente.send();	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
