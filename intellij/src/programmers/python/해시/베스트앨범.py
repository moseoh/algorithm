from collections import defaultdict


class Song:
    def __init__(self, index, genre, play_count):
        self.index = index
        self.genre = genre
        self.play_count = play_count

    def __str__(self):
        return f"{self.index}: {self.genre} {self.play_count}"


def solution(genres, plays):
    total_play_count_by_genres = defaultdict(int)
    songs = []
    for i, (genre, play) in enumerate(zip(genres, plays)):
        songs.append(Song(i, genre, play))
        total_play_count_by_genres[genre] += play

    songs.sort(key=lambda x: (-total_play_count_by_genres[x.genre], -x.play_count, x.index))

    answer = []
    genre_count = defaultdict(int)
    for song in songs:
        if genre_count[song.genre] < 2:
            answer.append(song.index)
            genre_count[song.genre] += 1

    return answer


def print_result(index, result, answer):
    template = f"""테스트 케이스 {index}: {"정답" if result == answer else "오답"}
    - 실행 결과: {result}
    - 기댓값: {answer}
"""

    if result == answer:
        print(template)
    else:
        raise SystemExit(template)


if __name__ == "__main__":
    # 테스트 케이스 1
    genres_1 = ["classic", "pop", "classic", "classic", "pop"]
    plays_1 = [500, 600, 150, 800, 2500]
    answer_1 = [4, 1, 3, 0]
    result_1 = solution(genres_1, plays_1)
    print_result(1, result_1, answer_1)

    # 테스트 케이스 1
    genres_1 = ["c", "c", "c", "c", "c", "b", "a"]
    plays_1 = [1, 2, 3, 4, 5, 100, 1]
    answer_1 = [5, 4, 3, 6]
    result_1 = solution(genres_1, plays_1)
    print_result(1, result_1, answer_1)
