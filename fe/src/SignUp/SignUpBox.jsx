import React, { useState } from 'react';
import CardinalSelectBox from './components/CardinalSelectBox';

import InputElement from './components/InputElement';
import SignUpBtn from './components/SignUpBtn';
import './css/SignUpBox.css';
import EmailStatus from './EmailStatus';

function SignUpBox() {
  const [isAgree, setIsAgree] = useState(false);
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPasswd, setconfirmPasswd] = useState('');
  const [name, setName] = useState('');

  const onChange = (e) => {
    setIsAgree(() => e.target.checked);
  };

  return (
    <div className="sign-up-box">
      <h3 className="sign-up-box-title">Sign Up</h3>
      <InputElement
        placeHolder="이메일"
        classNames="input-email"
        value={email}
        setValue={setEmail}
      />
      <EmailStatus email={email} />
      <InputElement
        placeHolder="비밀번호"
        classNames="input-password"
        value={password}
        setValue={setPassword}
      />
      <InputElement
        placeHolder="비밀번호 확인"
        classNames="input-password-confirm"
        value={confirmPasswd}
        setValue={setconfirmPasswd}
      />
      <InputElement
        placeHolder="이름"
        classNames="input-name"
        value={name}
        setValue={setName}
      />
      <CardinalSelectBox />
      <input type="checkbox" checked={isAgree} onChange={onChange} />
      개인정보 동의합니다.
      <SignUpBtn />
    </div>
  );
}

export default SignUpBox;
