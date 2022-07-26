import axios from 'axios';
import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';

import noImg from '../img/no_img.png';
import '../css/UserInfo.css';
import PostList from './PostList';

const UserInfo = function () {
  const { id } = useParams();
  const [user, setUser] = useState({});
  useEffect(() => {
    axios
      .get(`http://54.180.29.85:8080/api/user/${id}`)
      .then((response) => {
        setUser(response.data);
        console.log('response', response);
      })
      .catch((error) => {
        console.log('erroe', error);
      });
  }, []);
  return (
    <div className="userinfo">
      <div className="userinfo-top">
        <img src={noImg} alt="no profile" className="userinfo__img" />
        <div className="userinfo-spec">
          <span className="userinfo__name">{user.userName}</span>
          <span>{user.userEmail}</span>
          <span>{`${user.year}기  |  ${user.role}`}</span>
          <span>작성글 6</span>
        </div>
        <button type="button" className="userinfo-edit__button">
          수정하기
        </button>
      </div>
      <PostList />
    </div>
  );
};

export default UserInfo;
