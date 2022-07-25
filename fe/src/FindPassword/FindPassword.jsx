import React, { useState } from 'react';

import CardinalSelectBox from '../components/CardinalSelectBox';
import InputElement from '../components/InputElement';
import './FindPassword.css';

function FindPassword() {
  // eslint-disable-next-line no-unused-vars
  const [isSendClick, setIsSendClick] = useState(false);

  const onClick = () => {
    if (!isSendClick) {
      setIsSendClick(() => true);
    }
  };

  return (
    <div className="find-password">
      <div className="find-password-box">
        <div className="find-password__title">비밀번호 재설정</div>
        <h4>비밀번호를 잊어버리셨나요?</h4>
        <p>회원가입시 사용한 이메일을 입력하시면</p>
        <p>이메일로 인증번호 6자리를 보내드립니다.</p>
        <InputElement
          placeHolder="이름"
          classNames="find-password-name__input"
        />
        <CardinalSelectBox classNames="find-password-cardinal" />
        <button
          className={`find-password__button ${
            !isSendClick ? 'btn__active' : 'btn__inactive'
          }`}
          type="button"
          disabled={isSendClick}
          onClick={onClick}
        >
          코드 전송
        </button>
        {isSendClick ? (
          <div className="send-code--after">
            <div className="email-resend__container">
              <span>이메일을 받지 못했나요? </span>
              <button type="button" className="email-resend__button">
                이메일 재전송
              </button>
            </div>
            <InputElement
              placeHolder="인증번호 입력"
              classNames="certification-number__input"
            />
            <button type="button" className="cerify__button">
              인증완료
            </button>
          </div>
        ) : undefined}
      </div>
    </div>
  );
}

export default FindPassword;
