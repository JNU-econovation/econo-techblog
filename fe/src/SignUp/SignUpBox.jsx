import React, { useState } from 'react';
import CardinalSelectBox from './components/CardinalSelectBox';

import InputElement from './components/InputElement';
import SignUpBtn from './components/SignUpBtn';
import './css/SignUpBox.css';

function SignUpBox() {
  const [isAgree, setIsAgree] = useState(false);

  const onChange = (e) => {
    setIsAgree(() => e.target.checked);
  };

  return (
    <div className="sign-up-box">
      <h3 className="sign-up-box-title">Sign Up</h3>
      <InputElement placeHolder="이메일" classNames="input-email" />
      <span>이메일 인증하기</span>
      <InputElement placeHolder="비밀번호" classNames="input-password" />
      <InputElement
        placeHolder="비밀번호 확인"
        classNames="input-password-confirm"
      />
      <InputElement placeHolder="이름" classNames="input-name" />
      <CardinalSelectBox />
      <input type="checkbox" checked={isAgree} onChange={onChange} />
      개인정보 동의합니다.
      <SignUpBtn />
    </div>
  );
}

export default SignUpBox;
