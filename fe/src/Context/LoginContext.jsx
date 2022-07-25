/* eslint-disable no-case-declarations */
/* eslint-disable import/no-extraneous-dependencies */
/* eslint-disable react/forbid-prop-types */
/* eslint-disable import/prefer-default-export */
/* eslint-disable no-unused-vars */
import React, { createContext, useReducer, useContext } from 'react';
import PropTypes from 'prop-types';

const loginInfo = {
  createdDate: '2022/07/25 05:52:16',
  emailVerified: false,
  id: 1,
  role: 'USER',
  userEmail: 'ymecca730135@gmail.com',
  userName: '이서현',
  year: 23,
};

function loginReducer(state) {
  const saveData = {
    createdDate: state.createdDate,
    emailVerified: state.emailVerified,
    id: state.id,
    role: state.role,
    userEmail: state.userEmail,
    userName: state.userName,
    year: state.year,
  };
  console.log('saveData', saveData);
  return saveData;
}

const LoginStateContext = createContext();
const LoginDispatchContext = createContext();

export function LoginProvider({ children }) {
  const [state, dispatch] = useReducer(loginReducer, loginInfo);
  return (
    <LoginStateContext.Provider value={state}>
      <LoginDispatchContext.Provider value={dispatch}>
        {children}
      </LoginDispatchContext.Provider>
    </LoginStateContext.Provider>
  );
}

export function useLoginStateContext() {
  return useContext(LoginStateContext);
}

export function useLoginDispatchContext() {
  return useContext(LoginDispatchContext);
}

LoginProvider.propTypes = {
  children: PropTypes.object.isRequired,
};
