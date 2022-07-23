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

  const onSubmit = () => {
    axios
      .get(
        `http://54.180.29.85:8080/api/find-email/?year=${year}&userName=${userName}`,
      )
      .then((response) => {
        console.log('response', response);
        navigate('/findid'); // 추후 수정
      })
      .catch((error) => {
        console.log('error', error);
      });
  };
  return (
    <div className="find-id-box">
      <h3 className="find-id-box-title">아이디 찾기</h3>
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
    </div>
  );
}

export default FindIDBox;
