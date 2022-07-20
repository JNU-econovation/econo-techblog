import React from 'react';

import noImg from '../img/no_img.png';
import '../css/UserInfo.css';
import PostList from './PostList';

const UserInfo = function () {
  const user = {
    name: '김정은',
    email: '194914@jnu.ac.kr',
    year: 22,
    member: '일반회원',
    postNum: 6,
  };
  return (
    <div className="userinfo">
      <div className="userinfo-top">
        <img src={noImg} alt="no profile" className="userinfo__img" />
        <div className="userinfo-spec">
          <span className="userinfo__name">{user.name}</span>
          <span>{user.email}</span>
          <span>{`${user.year}기  |  ${user.member}`}</span>
          <span>{`작성글 ${user.postNum}`}</span>
        </div>
        <button type="button" className="userlist-edit__button">
          수정하기
        </button>
      </div>
      <PostList />
    </div>
  );
};

export default UserInfo;
