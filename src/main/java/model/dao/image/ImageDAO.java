package model.dao.image;

import model.persistence.image.Image;

public interface ImageDAO {

    void saveImage(Image image);

    void deleteImage(Image image);

    void updateImage(Image image);
    
    Image getImageForUserNickname(String nickname);

}
