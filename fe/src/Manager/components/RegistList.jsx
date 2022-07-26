/* eslint-disable object-curly-newline */
import React, { useState, useEffect } from 'react';
import Pagination from 'react-js-pagination';

import '../css/RegistList.css';
import '../../components/css/Pagination.css';
import '../css/Table.css';
import noImg from '../img/no_img.png';
import RoleSelectBox from './RoleSelectBox';

const RegistList = function () {
  const columns = ['', '이름', '이메일', '사용자 타입', '기수', '설정'];
  const [users, setUsers] = useState([]);
  const [page, setCurrentPage] = useState(0);
  useEffect(() => {
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
  }, [page]);
  return (
    <div className="regist-list">
      <div className="regist-list-top">
        <h2 className="regist-list__title">가입 신청 관리</h2>
        <div className="regist-list-edit">
          <span className="regist-list-text regist-list-text--blue">
            선택한 회원
          </span>
          <span className="regist-list-text">을</span>
          <RoleSelectBox isRejectable />
          <span className="regist-list-text">(으)로</span>
          <button type="button" className="regist-list-edit__button">
            변경하기
          </button>
        </div>
      </div>
      <table className="table">
        <colgroup>
          <col width="6%" />
          <col width="10%" />
          <col width="35%" />
          <col width="20%" />
          <col width="20%" />
          <col width="9%" />
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
              <td className="regist-list-setting">수락</td>
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

export default RegistList;
