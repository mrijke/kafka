package kafka.network.security

import kafka.network.security.store.JKSInitializer
import kafka.common.UnknownKeyStoreException
import javax.net.ssl.SSLContext

trait StoreInitializer {
  def initialize(config: AuthConfig): SSLContext
}

object KeyStores {
  def getKeyStore(name: String): StoreInitializer = {
    name.toLowerCase match {
      case JKSInitializer.name => JKSInitializer
      case _ => throw new UnknownKeyStoreException("%s is an unknown key store".format(name))
    }
  }
}
