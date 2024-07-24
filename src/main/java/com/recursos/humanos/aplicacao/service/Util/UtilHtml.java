package com.recursos.humanos.aplicacao.service.Util;

import com.recursos.humanos.aplicacao.dto.request.ParametrosEmailRequest;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class UtilHtml {

    public Map<String, String> construirParametrosHtml(ParametrosEmailRequest parametrosEmail) {
        Map<String, String> paransMap = new LinkedHashMap<>();
        String nomeParticipante = "nomeParticipante";
        String login = "login";
        String senha = "senha";

        paransMap.put(nomeParticipante, Utils.tratarPegarPrimeiroNome(parametrosEmail.getNomeParticipante()));
        paransMap.put(login, parametrosEmail.getLogin());
        paransMap.put(senha, parametrosEmail.getSenha());
        return paransMap;
    }

    public static String emailHtmlToString (String emailPath, Map<String, String> params){
        String emailContent = htmlToString(emailPath);
        for (Map.Entry<String, String> entry : params.entrySet()) {
            emailContent = emailPath.replaceAll(entry.getKey(), entry.getValue());
        }
        return emailContent;
    }

    private static String htmlToString(String emailPath) {
        InputStream template = null;

        try {
            template = new ClassPathResource(emailPath).getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new BufferedReader(new InputStreamReader(template))
                .lines().parallel().collect(Collectors.joining());

    }

}
