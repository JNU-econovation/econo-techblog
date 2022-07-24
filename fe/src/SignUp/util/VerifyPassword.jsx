export function isEmptyStatus(passwd, confirmPasswd) {
  return passwd === '' && confirmPasswd === '';
}

export function isSamePasswd(passwd, confirmPasswd) {
  return passwd === confirmPasswd;
}
