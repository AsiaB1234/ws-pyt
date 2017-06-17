/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyt.service;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pyt.exception.ForbiddenException;
import pyt.exception.UnauthorizedException;

@Service
public class AuthService {

    @Autowired
    private HttpSession session;

    public void verifyCurrentLoggedUser(Long userId) {
        Long sessionUserId = (Long) session.getAttribute("userId");
        if (sessionUserId == null) {
            throw new UnauthorizedException();
        }
        if (!sessionUserId.equals(userId)) {
            throw new ForbiddenException();
        }
    }

    public Long getCurrentLoggerUserId() {
        Long sessionUserId = (Long) session.getAttribute("userId");
        if (sessionUserId == null) {
            throw new UnauthorizedException();
        }
        return sessionUserId;
    }
}
