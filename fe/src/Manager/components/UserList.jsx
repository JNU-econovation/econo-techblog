/* eslint-disable */
import axios from 'axios';
import React, { useEffect, useState } from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';
import Pagination from 'react-js-pagination';

import '../css/UserList.css';
import '../../components/css/Pagination.css';
import noImg from '../img/no_img.png';
import settings from '../img/settings.png';
import SettingBox from './SettingBox';
import { useParams } from 'react-router-dom';

const UserList = function () {
  const { role } = useParams();
  const title = () => {
    switch (role) {
      case 'all':
        return '전체 회원 관리';
      case 'USER':
        return '일반 회원 관리';
      case 'GUEST':
        return '게스트 회원 관리';
      case 'ADMIN':
        return '관리자 회원 관리';
    }
  };
  const [users, setUsers] = useState([]);
  const columns = ['이름', '이메일', '사용자 타입', '기수', '설정'];
  const [page, setCurrentPage] = useState(0);
  useEffect(() => {
    if (role === 'all') {
      getUsers(`http://54.180.29.85:8080/api/user/all/${page}`);
    } else {
      getUsers(`http://54.180.29.85:8080/api/user/role/${page}/${role}`);
    }
  }, [role, page]);
  const getUsers = (url) => {
    axios
      .get(url)
      .then((response) => {
        setUsers(response.data);
        console.log('response', response);
      })
      .catch((error) => {
        console.log('erroe', error);
      });
  };
  const onClick = () => {};
  return (
    <div>
      <h2 className="userlist__title">{title()}</h2>
      <table className="userlist-table">
        <colgroup>
          <col width="12%" />
          <col width="40%" />
          <col width="20%" />
          <col width="20%" />
          <col width="8%" />
        </colgroup>
        <thead className="userlist-table__thead">
          <tr>
            {columns.map((column) => (
              <th key={column}>{column}</th>
            ))}
          </tr>
        </thead>
        <tbody>
          {users.map(({ id, userName, userEmail, role, year }) => (
            <tr key={id} className="userlist-table__tr">
              <td>
                <div className="userlist-table-user">
                  <img
                    src={noImg}
                    alt="noImg"
                    className="userlist-table-user__img"
                  />
                  <span className="userlist-table-user__name">{userName}</span>
                </div>
              </td>
              <td>{userEmail}</td>
              <td>{role}</td>
              <td>{year}</td>
              <td className="userlist-setting">
                <button
                  type="button"
                  className="userlist-setting-btn"
                  onClick={onClick}
                >
                  <img
                    src={settings}
                    alt="settings"
                    className="userlist-setting-btn__img"
                  />
                </button>
                <div className="userlist-setting-box">
                  <SettingBox id={id} />
                </div>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <Pagination
        activePage={page}
        itemsCountPerPage={8}
        totalItemsCount={users.length}
        pageRangeDisplayed={5}
        prevPageText="<"
        nextPageText=">"
        onChange={setCurrentPage}
      />
    </div>
  );
};

export default UserList;
