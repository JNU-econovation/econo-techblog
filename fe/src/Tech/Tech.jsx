import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import Pagination from 'react-js-pagination';
import { gql, useQuery } from '@apollo/client';

import './css/Tech.css';
import '../components/css/Pagination.css';
import write from './img/write.png';

import Banner from './components/Banner';
import Official from './components/Official';
import PostBox from '../components/PostBox';

const GET_POSTS = gql`
  query getPosts($mainCategory: String!) {
    findAllPosts(mainCategory: $mainCategory) {
      id
      userId
      content
      title
      official
      views
      hearts
      mainCategory
    }
  }
`;

const Tech = function () {
  const [movies, setMovies] = useState([]);
  const navigate = useNavigate();
  const onClick = () => {
    navigate('/write');
  };

  const result = useQuery(GET_POSTS, {
    variables: {
      mainCategory: 'TECH',
    },
  });
  console.log(result);
  const [currentPage, setCurrentPage] = useState(1);
  const postPerPage = 5;
  const getMovies = async () => {
    const response = await fetch(
      'https://yts.mx/api/v2/list_movies.json?minimum_rating=9&sort_by=year',
    );
    const json = await response.json();
    setMovies(json.data.movies);
  };

  useEffect(() => {
    getMovies();
  }, []);

  const indexOfLast = currentPage * postPerPage;
  const indexOfFirst = indexOfLast - postPerPage;
  const currentPosts = (posts) => {
    let slicePosts = 0;
    slicePosts = posts.slice(indexOfFirst, indexOfLast);
    return slicePosts;
  };
  return (
    <div className="tech">
      <Banner />
      <div className="tech__posts">
        <div className="tech-official">
          <div className="tech-official-top">
            <p className="tech__title">Official</p>
            <button
              type="button"
              className="tech-write_button"
              onClick={onClick}
            >
              <img src={write} alt="write" className="tech-write__img" />
              <span>글쓰기</span>
            </button>
          </div>
          <Official />
        </div>
        <div className="tech-recent">
          <p className="tech__title">Recent posts</p>
          {currentPosts(movies).map((item) => (
            <PostBox
              key={item.id}
              id={item.id}
              title={item.title}
              summary={item.summary}
            />
          ))}
          <Pagination
            activePage={currentPage}
            itemsCountPerPage={5}
            totalItemsCount={movies.length}
            pageRangeDisplayed={3}
            prevPageText="<"
            nextPageText=">"
            onChange={setCurrentPage}
          />
        </div>
      </div>
    </div>
  );
};

export default Tech;
