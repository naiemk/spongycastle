package org.spongycastle.tls.crypto;

import java.io.IOException;
import java.math.BigInteger;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.tls.ClientCertificateType;
import org.spongycastle.tls.ConnectionEnd;
import org.spongycastle.tls.KeyExchangeAlgorithm;
import org.spongycastle.tls.SignatureAlgorithm;

/**
 * Interface providing the functional representation of a single X.509 certificate.
 */
public interface TlsCertificate
{
    /**
     * @param signatureAlgorithm
     *            {@link SignatureAlgorithm}
     */
    TlsVerifier createVerifier(short signatureAlgorithm) throws IOException;

    /**
     * @return {@link ClientCertificateType}
     */
    short getClientCertificateType() throws IOException;

    byte[] getEncoded() throws IOException;

    byte[] getExtension(ASN1ObjectIdentifier extensionOID) throws IOException;

    BigInteger getSerialNumber();

    /**
     * @param connectionEnd
     *            {@link ConnectionEnd}
     * @param keyExchangeAlgorithm
     *            {@link KeyExchangeAlgorithm}
     */
    // TODO[tls-ops] This is expected to be only transitional and eventually redundant
    TlsCertificate useInRole(int connectionEnd, int keyExchangeAlgorithm) throws IOException;
}
