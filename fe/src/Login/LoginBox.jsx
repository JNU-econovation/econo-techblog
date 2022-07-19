import React from 'react';
import InputElement from '../components/InputElement';

import './css/LoginBox.css';
import LoginBtn from './LoginBtn';
import SignUpLinkBtn from './SignUpLinkBtn';
import LoginLink from './LoginLink';

function LoginBox() {
  return (
    <div className="login-box">
      <h3 className="login-box__title">Sign in</h3>
      <InputElement classNames="login-box-id__input" placeHolder="ID" />
      <InputElement
        classNames="login-box-pw__input"
        placeHolder="Password"
        type="password"
      />
      <LoginBtn />
      <SignUpLinkBtn />
      <LoginLink />
    </div>
  );
}

export default LoginBox;
