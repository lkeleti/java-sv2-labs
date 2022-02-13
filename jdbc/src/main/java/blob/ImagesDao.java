package blob;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;

public class ImagesDao {
    private DataSource dataSource;

    public ImagesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveImage(String filename, InputStream is) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO images (filename, content) VALUES(?,?)")
        ) {
            pstmt.setString(1, filename);
            Blob blob = conn.createBlob();
            fillBlob(is, blob);
            pstmt.setBlob(2, blob);
            pstmt.executeUpdate();
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can't insert image", se);
        }
    }

    private void fillBlob(InputStream is, Blob blob) throws SQLException{
        try (OutputStream os =  blob.setBinaryStream(1)){
        is.transferTo(os);
        }
        catch (IOException ie) {
            throw new IllegalStateException("Can't write blob", ie);
        }
    }

    public InputStream getImageByName(String name) {
        try ( Connection conn = dataSource.getConnection();
              PreparedStatement pstmt = conn.prepareStatement("SELECT content FROM images WHERE filename = ?");
        ){
            pstmt.setString(1,name);
            return readInputStreamFormBlob(pstmt);
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can't read blob", se);
        }
    }

    private InputStream readInputStreamFormBlob(PreparedStatement pstmt) throws SQLException {
        try (ResultSet rs = pstmt.executeQuery())
        {
            if (rs.next()) {
                Blob blob = rs.getBlob("content");
                return blob.getBinaryStream();
            }
            throw new IllegalStateException("Can't find record");
        }
    }
}
