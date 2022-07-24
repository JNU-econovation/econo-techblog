import axios from 'axios';
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

import CardinalSelectBox from '../components/CardinalSelectBox';
import InputElement from '../components/InputElement';
import './css/FindIDBox.css';

function FindIDBox() {
  const [userName, setUserName] = useState('');
  const [year, setYear] = useState(23);
  const navigate = useNavigate();
  const [isModal, setIsModal] = useState(false);

  const onModalHandler = () => {
    setIsModal(() => false);
  };

  const onSubmit = () => {
    axios
      .get(`/api/find-email/?year=${year}&userName=${userName}`)
      .then((response) => {
        console.log('response', response);
        navigate('/findid'); // 추후 수정
      })
      .catch((error) => {
        console.log('error', error);
        setIsModal(() => true);
      });
  };
  return (
    <div className="find-id-box">
      <div className="find-id-box-title">아이디 찾기</div>
      <h4>아이디를 잃어버리셨나요?</h4>
      <p>걱정하지 마세요. 아이디 찾기는 간단합니다.</p>
      <p>이름과 기수만 알려주세요.</p>
      <InputElement
        placeHolder="이름"
        value={userName}
        setValue={setUserName}
        classNames="find-id-name__input"
        type="text"
      />
      <CardinalSelectBox
        setValue={setYear}
        classNames="find-id-cardinal__select"
      />
      <button className="find-id-btn" type="submit" onClick={onSubmit}>
        아이디 찾기
      </button>
      {isModal ? (
        <div className="find-id-error__modal">
          <div className="find-id-error__modal-box">
            <div className="find-id-error__modal-box--header">
              <h3>아이디 찾기 실패</h3>
              <button type="button" onClick={onModalHandler}>
                X
              </button>
            </div>
            <div>
              잘못된 계정인증 요청입니다. 아이디 비밀번호 찾기를 다시하거나
              사이트 관리자에게 계정정보를 문의해주세요. 정보확인이 불가능한
              경우, 관리자에게로 문의 바랍니다.
            </div>
            <button type="button" onClick={onModalHandler}>
              확인
            </button>
          </div>
        </div>
      ) : undefined}
    </div>
  );
}

export default FindIDBox;
