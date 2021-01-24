package weblogic.jdbc.common;

import java.io.OutputStream;
import java.io.Writer;
import java.sql.SQLException;

/**
 * 写这个接口的目的是为了在非Weblogic平台上不用放weblogic.jar包
 * (enp.EnpArticleContent.java会将一个clob造型成此接口，如果没有编译及运行出错)，
 * 而在weblogic平台上会调用weblogic.jar中相同的接口，因为weblogic.jar在classpath的较前面
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
public interface OracleClob
{

    public abstract OutputStream getAsciiOutputStream()
        throws SQLException;

    public abstract Writer getCharacterOutputStream()
        throws SQLException;
}
