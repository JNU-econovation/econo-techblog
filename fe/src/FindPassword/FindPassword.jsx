import React, { useState } from 'react';

import CardinalSelectBox from '../components/CardinalSelectBox';
import InputElement from '../components/InputElement';

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
      <h3 className="find-password__title">비밀번호 찾기</h3>
      <InputElement placeHolder="이름" />
      <CardinalSelectBox />
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
        <div>
          <div>
            <p>이메일 전송하기</p>
            <button type="button">이메일 재전송</button>
          </div>
          <InputElement placeHolder="인증번호 입력" />
          <button type="button">인증완료</button>
        </div>
      ) : undefined}
    </div>
  );
}

export default FindPassword;
