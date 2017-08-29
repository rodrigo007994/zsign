/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zencherry.zsign;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.Normalizer;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.commons.ssl.PKCS8Key;

/**
 *
 * @author rodrigo
 */
public class Sign {
    public static String getSign(String cadenaOriginal, String cerPath, String keyPath, String cerPass) throws NoSuchAlgorithmException, FileNotFoundException, CertificateException, IOException, GeneralSecurityException{
			cadenaOriginal= Normalizer.normalize(cadenaOriginal, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
			MessageDigest md = MessageDigest.getInstance("SHA1");
			File certificadoArchivo = new File(cerPath);
			InputStream is = new FileInputStream(certificadoArchivo);
			CertificateFactory cf = CertificateFactory.getInstance("X.509");
			X509Certificate xcertificado=(X509Certificate)cf.generateCertificate(is);
			byte[] byteArray= xcertificado.getSerialNumber().toByteArray();
			String numerocertificadoFinal = new String(byteArray);
			String certificadoFinal = new String(Base64.encodeBase64(xcertificado.getEncoded()));
			System.out.println(certificadoFinal);
			File llaveArchivo = new File(keyPath);
			InputStream llaveis = new FileInputStream(llaveArchivo);
			byte[] llavePrivadaBytes = IOUtils.toByteArray(llaveis);
			String clave = cerPass;
			PKCS8Key pkcs8 = new PKCS8Key(llavePrivadaBytes, clave.toCharArray());
			PrivateKey priv = pkcs8.getPrivateKey();
			Signature dsa = Signature.getInstance("SHA1withRSA", "SunJSSE");
			dsa.initSign(priv);
			dsa.update(cadenaOriginal.getBytes());
			byte[] realSig = dsa.sign();
			String selloFinal = new String(Base64.encodeBase64(realSig));
                        System.out.println(selloFinal);
        return selloFinal;
    }
    
}
