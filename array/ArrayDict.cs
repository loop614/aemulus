#!/usr/bin/env dotnet-script
/*
Check if two arrays have the same values, without sorting
*/
bool CheckIfArraysAreTheSame<T>(T[] a, T[] b) where T : notnull
{
    if (a.Length != b.Length)
    {
        return false;
    }

    Dictionary<T, int> occurancesA = new();
    Dictionary<T, int> occurancesB = new();

    for (int i = 0; i < a.Length; i++)
    {
        if (!occurancesA.TryGetValue(a[i], out int valueA))
        {
            valueA = 0;
            occurancesA[a[i]] = valueA;
        }

        occurancesA[a[i]] = ++valueA;

        if (!occurancesB.TryGetValue(b[i], out int valueB))
        {
            valueB = 0;
            occurancesB[b[i]] = valueB;
        }

        occurancesB[b[i]] = ++valueB;
    }

    return DictionaryEquals<T, int>(occurancesB, occurancesA);
}

/*
Make array unique, without sets
*/
T[] MakeArrayUnique<T>(T[] a) where T : notnull
{
    Dictionary<T, int> occurances = new();
    for (int i = 0; i < a.Length; i++)
    {
        if (!occurances.TryGetValue(a[i], out int value))
        {
            value = 0;
            occurances[a[i]] = value;
        }

        occurances[a[i]] = ++value;
    }

    return occurances.Keys.ToArray();
}

/*
Compare Two Dictionarys
https://stackoverflow.com/questions/21758074/compare-two-dictionaries-for-equality
*/
bool DictionaryEquals<TKey, TValue>(Dictionary<TKey, TValue> x, Dictionary<TKey, TValue> y) where TKey : notnull
{
    if (x.Count != y.Count)
    {
        return false;
    }
    if (x.Keys.Except(y.Keys).Any())
    {
        return false;
    }
    if (y.Keys.Except(x.Keys).Any())
    {
        return false;
    }
    foreach (var pair in x)
    {
        if (!EqualityComparer<TValue>.Default.Equals(pair.Value, y[pair.Key]))
        {
            return false;
        }
    }

    return true;
}

int[] example1 = [1, 2, 3, 3];
int[] res1;
res1 = MakeArrayUnique(example1);
Console.WriteLine(string.Join("\t", res1));


int[] example2 = [1, 1, 1, 2, 2, 3, 3];
int[] res2;
res2 = MakeArrayUnique(example2);
Console.WriteLine(string.Join("\t", res2));

bool comparison = CheckIfArraysAreTheSame(res1, res2);
Console.WriteLine(comparison);

example1 = [1, 1, 1, 2, 2, 3, 3];
example2 = [3, 3, 1, 1, 1, 2, 2];
comparison = CheckIfArraysAreTheSame(example1, example2);
Console.WriteLine(comparison == true);

example1 = [2, 1, 1, 2, 2, 3, 3];
example2 = [3, 3, 1, 1, 1, 2, 2];
comparison = CheckIfArraysAreTheSame(example1, example2);
Console.WriteLine(comparison == false);
