/* eslint-disable */
import React, { useState } from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';
import Pagination from 'react-js-pagination';

import '../css/UserList.css';
import '../../components/css/Pagination.css';
import noImg from '../img/no_img.png';
import settings from '../img/settings.png';

const UserList = function () {
  const data = [
    {
      name: '이윤성',
      email: '181111@jnu.ac.kr',
      usertype: '관리자',
      year: '21기',
    },
    {
      name: '이윤성',
      email: '181111@jnu.ac.kr',
      usertype: '관리자',
      year: '21기',
    },
    {
      name: '이윤성',
      email: '181111@jnu.ac.kr',
      usertype: '관리자',
      year: '21기',
    },
    {
      name: '이윤성',
      email: '181111@jnu.ac.kr',
      usertype: '관리자',
      year: '21기',
    },
    {
      name: '이윤성',
      email: '181111@jnu.ac.kr',
      usertype: '관리자',
      year: '21기',
    },
    {
      name: '이윤성',
      email: '181111@jnu.ac.kr',
      usertype: '관리자',
      year: '21기',
    },
    {
      name: '이윤성',
      email: '181111@jnu.ac.kr',
      usertype: '관리자',
      year: '21기',
    },
    {
      name: '이윤성',
      email: '181111@jnu.ac.kr',
      usertype: '관리자',
      year: '21기',
    },
  ];
  const columns = ['이름', '이메일', '사용자 타입', '기수', '설정'];
  const [currentPage, setCurrentPage] = useState(1);
  const onClick = (e) => {
    console.log(e.screenX);
  };
  return (
    <div>
      <h2 className="userlist__title">전체 회원 관리</h2>
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
          {data.map(({ name, email, usertype, year }) => (
            <tr key={email} className="userlist-table__tr">
              <td>
                <div className="userlist-table-user">
                  <img
                    src={noImg}
                    alt="noImg"
                    className="userlist-table-user__img"
                  />
                  <span className="userlist-table-user__name">{name}</span>
                </div>
              </td>
              <td>{email}</td>
              <td>{usertype}</td>
              <td>{year}</td>
              <td>
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
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <Pagination
        activePage={currentPage}
        itemsCountPerPage={5}
        totalItemsCount={data.length}
        pageRangeDisplayed={3}
        prevPageText="<"
        nextPageText=">"
        onChange={setCurrentPage}
      />
    </div>
  );
};

export default UserList;
