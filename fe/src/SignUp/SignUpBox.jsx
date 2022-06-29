import React, { useState } from 'react';
import CardinalSelectBox from './components/CardinalSelectBox';

import InputElement from './components/InputElement';
import SignUpBtn from './components/SignUpBtn';
import './css/SignUpBox.css';

function SignUpBox() {
  const [password, setPassword] = useState('');
  const [rePassword, setRePassword] = useState('');
  const [email, setEmail] = useState('');
  const [name, setName] = useState('');
  return (
    <div className="sign-up-box">
      <h3 className="sign-up-box-title">Sign Up</h3>
      <InputElement
        placeHolder="이메일"
        classNames="input-email"
        setInput={setEmail}
        inputValue={email}
      />
      <span>이메일 인증하기</span>
      <InputElement
        placeHolder="비밀번호"
        classNames="input-password"
        setInput={setPassword}
        inputValue={password}
      />
      <InputElement
        placeHolder="비밀번호 확인"
        classNames="input-password-confirm"
        setInput={setRePassword}
        inputValue={rePassword}
      />
      <InputElement
        placeHolder="이름"
        classNames="input-name"
        setInput={setName}
        inputValue={name}
      />
      <CardinalSelectBox />
      <SignUpBtn />
    </div>
  );
}

export default SignUpBox;
