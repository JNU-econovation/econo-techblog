/* eslint-disable */
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
// eslint-disable-next-line import/no-extraneous-dependencies
import Pagination from 'react-js-pagination';

import '../css/UserList.css';
import '../css/Table.css';
import '../../components/css/Pagination.css';
import noImg from '../img/no_img.png';
import settings from '../img/settings.png';
import SettingBox from './SettingBox';
import RoleSelectBox from './RoleSelectBox';

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
  const [checkedList, setCheckedList] = useState([]);
  const onChange = (checked, item) => {
    if (checked) {
      setCheckedList([...checkedList, item]);
    } else if (!checked) {
      setCheckedList(checkedList.filter((el) => el !== item));
    }
  };

  const [users, setUsers] = useState([]);
  const columns = ['', '이름', '이메일', '사용자 타입', '기수', '설정'];
  const [page, setCurrentPage] = useState(0);
  useEffect(() => {
    // if (role === 'all') {
    //   getUsers(`http://54.180.29.85:8080/api/user/all/${page}`);
    // } else {
    //   getUsers(`http://54.180.29.85:8080/api/user/role/${page}/${role}`);
    // }
    const data = [
      {
        id: 1,
        userName: '이윤성',
        userEmail: '181111@jnu.ac.kr',
        role: 'GUEST',
        year: '21기',
      },
    ];
    setUsers(data);
  }, [role, page]);
  // const getUsers = (url) => {
  //   axios
  //     .get(url)
  //     .then((response) => {
  //       setUsers(response.data);
  //       console.log('response', response);
  //     })
  //     .catch((error) => {
  //       console.log('erroe', error);
  //     });
  // };
  const onClick = () => {};
  return (
    <div className="userlist">
      <div className="userlist-top">
        <h2 className="userlist__title">{title()}</h2>
        <div className="userlist-edit">
          <span className="userlist-text userlist-text--blue">선택한 회원</span>
          <span className="userlist-text">을</span>
          <RoleSelectBox isRejectable={false} />
          <span className="userlist-text">(으)로</span>
          <button type="button" className="userlist-edit__button">
            변경하기
          </button>
        </div>
      </div>
      <table className="table">
        <colgroup>
          <col width="6%" />
          <col width="10%" />
          <col width="34%" />
          <col width="20%" />
          <col width="20%" />
          <col width="10%" />
        </colgroup>
        <thead className="table__thead">
          <tr>
            {columns.map((column) => (
              <th key={column}>{column}</th>
            ))}
          </tr>
        </thead>
        <tbody>
          {users.map(({ id, userName, userEmail, role, year }) => (
            <tr key={id} className="table__tr">
              <td>
                <input
                  type="checkbox"
                  name="user"
                  value={id}
                  className="postlist-table__checkbox"
                  onChange={(e) => onChange(e.target.checked, e.target.value)}
                />
              </td>
              <td>
                <div className="table-user">
                  <img src={noImg} alt="noImg" className="table-user__img" />
                  <span className="table-user__name">{userName}</span>
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
