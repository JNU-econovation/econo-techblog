import React from 'react';
import InputElement from '../components/InputElement';

import './css/LoginBox.css';
import LoginBtn from './LoginBtn';
import SignUpLinkBtn from './SignUpLinkBtn';

function LoginBox() {
  return (
    <div className="login-box">
      <h3 className="login-box-title">Sign in</h3>
      <InputElement placeHolder="ID" />
      <InputElement placeHolder="Password" />
      <LoginBtn />
      <SignUpLinkBtn />
      <div className="login-link-container">
        <div>아이디 찾기</div>
        <div>|</div>
        <div>비밀번호 찾기</div>
      </div>
    </div>
  );
}

export default LoginBox;
