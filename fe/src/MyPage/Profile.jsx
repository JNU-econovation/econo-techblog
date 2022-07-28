/* eslint-disable react/prop-types */
import React from 'react';

import { useLoginStateContext } from '../Context/LoginContext';
import './css/Profile.css';

function Profile({ isMyInfoSelect, setIsMyInfoSelect }) {
  const loginState = useLoginStateContext();

  const onClickProfileEdit = () => {
    setIsMyInfoSelect(() => !isMyInfoSelect);
  };
  return (
    <div className="profile">
      <h3>프로필</h3>
      <div className="profile__container">
        <div className="profile-content__container">
          <img alt="profile_img" className="profile__img" />
          <div className="profile-description__container">
            <p>
              <span>{loginState.userName}</span>
              <span>님</span>
            </p>
            <span>{loginState.userEmail}</span>
            <p>
              <span>{loginState.year}</span>
              <span>기</span>
              <span>|</span>
              <span>{loginState.role}</span>
            </p>
          </div>
        </div>
        <button
          className="profile-edit__button"
          type="button"
          onClick={onClickProfileEdit}
        >
          내 정보 수정
        </button>
      </div>
      <div className="profile-stat__container">
        <div className="profile-stat-like__container">
          <p>받은 좋아요</p>
          <p>0 개</p>
        </div>
        <div className="profile-stat-comment__container">
          <p>받은 댓글</p>
          <p>0 개</p>
        </div>
      </div>
    </div>
  );
}

export default Profile;
