import React from 'react';
import CardinalSelectBox from './components/CardinalSelectBox';

import InputElement from './components/InputElement';
import SignUpBtn from './components/SignUpBtn';
import './css/SignUpBox.css';

function SignUpBox() {
  return (
    <div className="sign-up-box">
      <h3 className="sign-up-box-title">Sign Up</h3>
      <InputElement placeHolder="이메일" classNames="input-email" />
      <InputElement placeHolder="비밀번호" classNames="input-password" />
      <InputElement
        placeHolder="비밀번호 확인"
        classNames="input-password-confirm"
      />
      <InputElement placeHolder="이름" classNames="input-name" />
      <CardinalSelectBox />
      <SignUpBtn />
    </div>
  );
}

export default SignUpBox;
