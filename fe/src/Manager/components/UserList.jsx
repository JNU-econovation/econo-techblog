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
  const columns = ['', '이름', '이메일', '사용자 타입', '기수', '설정'];
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
  const [users, setUsers] = useState([]);
  const [page, setCurrentPage] = useState(0);
  const [open, setOpen] = useState(false);
  const [loading, setLoading] = useState(false);
  const [currentOption, setCurrentOption] = useState('GUEST');
  const getUsers = (url) => {
    console.log('url:', url);
    axios({
      method: 'get',
      url: url,
      headers: {
        'Content-Type': '*/*',
      },
    })
      .then((response) => {
        setUsers(response.data);
        console.log('response', response);
      })
      .catch((error) => {
        console.log('error', error);
      });
  };
  const onOpen = () => {
    setOpen(!open);
  };
  const onSelect = (item) => {
    setCurrentOption(item.target.innerText);
    setOpen(false);
  };
  const onChange = (checked, item) => {
    if (checked) {
      setCheckedList((checkedList) => [...checkedList, item]);
    } else if (!checked) {
      setCheckedList(checkedList.filter((el) => el !== item));
    }
  };
  useEffect(() => {
    if (role === 'all') {
      getUsers(`http://168.131.30.127:8080/api/user/all/${page}`);
    } else {
      getUsers(`http://168.131.30.127:8080/api/user/role/${page}/${role}`);
    }
    setLoading(true);
  }, [role, page, loading]);

  // 사용자 권한 변경
  const onEditClick = () => {
    checkedList.forEach((userId) => {
      const user = users.find((elem) => elem.id == userId);
      console.log('user', user);
      if (user) {
        const form = new FormData();
        form.append('userEmail', user.userEmail);
        form.append('year', user.year);
        form.append('userName', user.userName);
        form.append('role', currentOption);
        axios({
          method: 'post',
          url: `http://168.131.30.127:8080/api/user/${user.id}`,
          data: form,
        })
          .then((response) => {
            console.log('response', response);
            location.reload();
          })
          .catch((error) => {
            console.log('error', error);
          });
        setLoading(false);
      }
    });
  };
  return (
    <div className="userlist">
      <div className="userlist-top">
        <h2 className="userlist__title">{title()}</h2>
        <div className="userlist-edit">
          <span className="userlist-text userlist-text--blue">선택한 회원</span>
          <span className="userlist-text">을</span>
          <RoleSelectBox
            isRejectable={false}
            onOpen={onOpen}
            onSelect={onSelect}
            isOpen={open}
            currentOption={currentOption}
          />
          <span className="userlist-text">(으)로</span>
          <button
            onClick={onEditClick}
            type="submit"
            className="userlist-edit__button"
          >
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
                <button type="button" className="userlist-setting-btn">
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
