import React from 'react';
import InputElement from '../components/InputElement';

import './css/LoginBox.css';
import LoginBtn from './LoginBtn';
import SignUpLinkBtn from './SignUpLinkBtn';
import LoginLink from './LoginLink';

function LoginBox() {
  return (
    <div className="login-box">
      <h3 className="login-box-title">Sign in</h3>
      <InputElement placeHolder="ID" />
      <InputElement placeHolder="Password" />
      <LoginBtn />
      <SignUpLinkBtn />
      <LoginLink />
    </div>
  );
}

export default LoginBox;
