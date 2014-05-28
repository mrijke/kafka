package kafka.network.security

import kafka.utils.VerifiableProperties
import kafka.utils.Utils
import kafka.utils.Logging

object AuthConfig {
  val DEFAULT_SECURITY_CONFIG = "config/client.security.properties"
}

class AuthConfig(var securityConfigFile: String) extends Logging {

  val props = {
    if (securityConfigFile == null) {
      warn("securityConfigFile is null, using default securityConfigFile %s".format(AuthConfig.DEFAULT_SECURITY_CONFIG))
      securityConfigFile = AuthConfig.DEFAULT_SECURITY_CONFIG
    }
    new VerifiableProperties(Utils.loadProps(securityConfigFile))
  }

  val keystoreType = props.getString("keystore.type")

  /** Request client auth */
  val wantClientAuth = props.getBoolean("want.client.auth", false)

  /** Require client auth */
  val needClientAuth = props.getBoolean("need.client.auth", false)

  /** Keystore file location */
  val keystore = props.getString("keystore")

  /** Keystore file password */
  val keystorePwd = props.getString("keystorePwd")

  /** Keystore key password */
  val keyPwd = props.getString("keyPwd")

  /** Truststore file location */
  val truststore = props.getString("truststore")

  /** Truststore file password */
  val truststorePwd = props.getString("truststorePwd")
}
