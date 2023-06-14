package email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

import model.vo.Email;

public class GerenciadorEmail {

	public void encaminharEmailGerenciador(Email email) {
		//Email utilizamo para encaminhar pdf
		//Chave de segurança deste e-mail
		String nomeEmail = "destinatário";
		String senha = "key";
		
		MultiPartEmail emailRemetente = new MultiPartEmail();
		emailRemetente.setHostName("smtp.gmail.com");
		emailRemetente.setSmtpPort(465);
		emailRemetente.setAuthenticator(new DefaultAuthenticator(nomeEmail, senha));
		emailRemetente.setSSLOnConnect(true);
		
		try {
			emailRemetente.setFrom(nomeEmail);
			emailRemetente.setSubject("Treino Completo - " + email.getNomeUsuario());
			emailRemetente.setMsg("Mensagem que o cliente irá receber");
			
			emailRemetente.addTo(email.getEmailUsuario());
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
