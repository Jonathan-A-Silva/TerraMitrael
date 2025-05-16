package control.servlet.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.dao.image.ImageDAO;
import model.dao.image.ImageDAOImpl;
import model.entities.persistence.image.Image;
import model.entities.persistence.user.User;

@MultipartConfig
@WebServlet(urlPatterns = {"/save-image", "/show-user-image", "/show-user-image-nickname"})
public class ImageServlet extends HttpServlet {

    private ImageDAO ImageDAO;

    public void init() {
        ImageDAO = new ImageDAOImpl();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/save-image" -> saveUserImage(request, response);
                case "/show-user-image" -> showUserImage(request, response);
                case "/show-user-image-nickname" -> showUserImageNickname(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveUserImage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User User = null;

        if (session != null && session.getAttribute("User") != null) {
            User = (User) session.getAttribute("User");
            Part filePart = request.getPart("image");

            byte[] imagem = filePart.getInputStream().readAllBytes();
            String tipo = filePart.getContentType();

            Image ImageExistente = ImageDAO.getImageForUserNickname(User.getNickname());

            try {
                if (ImageExistente != null) {
                    ImageExistente.setImage(imagem);
                    ImageExistente.setType(tipo);
                    ImageDAO.updateImage(ImageExistente);
                } else {
                    Image novaImage = new Image(imagem, tipo, User);
                    ImageDAO.saveImage(novaImage);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        response.sendRedirect(request.getContextPath() + "/perfil");
    }

    private void showUserImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        Image ImageRecuperada;

        try {
            User User = (User) session.getAttribute("User");
            ImageRecuperada = ImageDAO.getImageForUserNickname(User.getNickname());
        } catch (Exception e) {
            ImageRecuperada = null;
        }

        showImage(response, ImageRecuperada);

    }

    private void showUserImageNickname(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Image ImageRecuperada;
        String nickname = request.getParameter("nickname");

        try {
            ImageRecuperada = ImageDAO.getImageForUserNickname(nickname);
        } catch (Exception e) {
            ImageRecuperada = null;
        }

        showImage(response, ImageRecuperada);

    }

    private void showImage(HttpServletResponse response, Image Image) throws IOException {

        try {
            response.setContentType(Image.getType());
            response.setContentLength(Image.getImage().length);
            response.getOutputStream().write(Image.getImage());
        } catch (Exception e) {

            File arquivoPadrao = new File(getServletContext().getRealPath("/recursos/imagens/user.png"));

            response.setContentType("image/png");
            response.setContentLength((int) arquivoPadrao.length());

            try (FileInputStream fis = new FileInputStream(arquivoPadrao);
                 OutputStream out = response.getOutputStream()) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }

        }

    }

}