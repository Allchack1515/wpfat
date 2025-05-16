package pl.dmcs.rkotas.service;

public interface ReCaptchaService {
    boolean verify(String captcha);
}
