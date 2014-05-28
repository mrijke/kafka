package kafka.common

/**
 * Created by ilyutov on 6/2/14.
 */
class UnknownKeyStoreException(message: String) extends RuntimeException(message) {
  def this() = this(null)
}
