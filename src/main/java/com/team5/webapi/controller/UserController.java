package com.team5.webapi.controller;

import java.util.List;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team5.webapi.interfaces.EmailService;
import com.team5.webapi.model.User;
import com.team5.webapi.repository.UserRepository;
import com.team5.webapi.utils.RandomString;

@RestController
@Component
public class UserController implements EmailService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  public JavaMailSender mailSender;

  @RequestMapping(value = "/user", method = { RequestMethod.GET })
  public User get(User user) {
    User userData;
    if (user.getId() != null)
      userData = userRepository.findById(user.getId()).get();
    else
      userData = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());

    if (userData == null) {
      userData = new User();
    }
    return userData;
  }

  @RequestMapping(value = "/user", method = { RequestMethod.PUT })
  public User update(User user) {
    userRepository.updateUser(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getPhone(),
        user.getIntroduce(), user.getProfileImagePath());
    User userData = userRepository.findById(user.getId()).get();
    return userData;
  }

  @RequestMapping(value = "/user", method = { RequestMethod.DELETE })
  public User remove(User user) {
    userRepository.deleteByEmail(user.getEmail());

    return new User();
  }

  @RequestMapping(value = "/user", method = { RequestMethod.POST })
  public User create(User user) {
    User userData = userRepository.findByEmail(user.getEmail());

    if (userData != null) {
      userData = new User();
    } else {
      RandomString randomString = new RandomString(36);
      String authKey = randomString.nextString();
      user.setAuthKey(authKey);
      userData = userRepository.save(user);
      try {
        sendSimpleMessage(userData.getEmail(), "HABIT 인증메일입니다.",
            "http://ec2-52-79-186-214.ap-northeast-2.compute.amazonaws.com:8080/auth?authKey=" + authKey
                + "\n 링크로 이동하세요.");
      } catch (Exception e) {
        // e.printStackTrace();
      }
    }

    // userData = userRepository.findById(user.getId()).get();

    return userData;
  }

  class ResponseMessage {
    private boolean result;
    private String message;

    /**
     * @return the message
     */
    public String getMessage() {
      return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
      this.message = message;
    }

    public boolean getResult() {
      return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(boolean result) {
      this.result = result;
    }
  }

  @RequestMapping(value = "/auth", method = { RequestMethod.GET })
  public ResponseMessage authEmail(String authKey) {
    User userData = userRepository.findByAuthKey(authKey);
    ResponseMessage responseMessage = new ResponseMessage();

    if (userData != null) {
      userRepository.authEmail(userData.getId(), true);
      userData.setAuth(true);

      responseMessage.setResult(true);
      responseMessage.setMessage("인증완료 되었습니다.");
    } else {
      userData = new User();

      responseMessage.setResult(false);
      responseMessage.setMessage("없는 계정입니다. 인증 불가.");
    }

    return responseMessage;
  }

  @RequestMapping("/users")
  // @Autowired
  public List<User> getUsers(Model model) {
    // Optional<User> resultUser = userRepository.findById(0);

    List<User> userList = userRepository.findAll();

    return userList;
  }

  public void sendSimpleMessage(String to, String subject, String text) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(to);
    message.setSubject(subject);
    message.setText(text);
    mailSender.send(message);
  }

}